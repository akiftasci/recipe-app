package com.abn.recipes.controller;

import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.model.AuthenticationRequest;
import com.abn.recipes.model.AuthenticationResponse;
import com.abn.recipes.model.Recipe;
import com.abn.recipes.service.MyUserDetailsService;
import com.abn.recipes.service.RecipeService;
import com.abn.recipes.utils.JwtUtil;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class RecipeController {

    private final RecipeService recipeService;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;

    public RecipeController(
        final RecipeService recipeService,
        final AuthenticationManager authenticationManager,
        final MyUserDetailsService userDetailsService,
        final JwtUtil jwtTokenUtil
    ) {
        this.recipeService = recipeService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @PostMapping(value = "/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username password", e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping()
    public List<RecipeDto> getRecipes() {
        return recipeService.getReceipts();
    }

    @PostMapping()
    public RecipeDto persistRecipe(@RequestBody final RecipeDto recipeDto) {
        return recipeService.persistData(recipeDto);
    }

    @PutMapping(value = "/update")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return recipeService.update(recipe);
    }

    @DeleteMapping(value = "/delete")
    public void deleteRecipe(@RequestBody Recipe recipe) {
        recipeService.delete(recipe);

    }

}

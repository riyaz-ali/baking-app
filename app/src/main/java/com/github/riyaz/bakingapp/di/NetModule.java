package com.github.riyaz.bakingapp.di;

import com.github.riyaz.bakingapp.net.RecipeService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger module for network dependencies.
 * This module contains {@code @Provide}rs for wiring network dependencies
 *
 * @author Riyaz
 */
@Module public class NetModule {
  // constant to use with @Named
  final static String BASE_URL = "base-url";

  @Singleton @Provides RecipeService provideRecipeService(Retrofit retrofit){
    return retrofit.create(RecipeService.class);
  }

  @Singleton @Provides Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl,
      GsonConverterFactory factory, OkHttpClient client) {
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(factory)
        .build();
  }

  @Provides GsonConverterFactory provideGsonFactory(Gson gson){
    return GsonConverterFactory.create(gson);
  }

  @Singleton @Provides Gson provideGson(){
    return new GsonBuilder().create();
  }

  @Singleton @Provides OkHttpClient provideOkHttpClient(){
    return new OkHttpClient.Builder().build();
  }
}

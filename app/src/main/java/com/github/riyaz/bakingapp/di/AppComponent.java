package com.github.riyaz.bakingapp.di;

import com.github.riyaz.bakingapp.BakingApp;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Named;

/**
 * Main Dagger Object-graph
 *
 * @author Riyaz
 */
@Component(
    modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetModule.class,
        ActivityBuilderModule.class
    }
) public interface AppComponent extends AndroidInjector<BakingApp> {
  @Component.Builder abstract class Builder extends AndroidInjector.Builder<BakingApp> {
    @BindsInstance public abstract Builder server(@Named(NetModule.BASE_URL) String url);
  }
}

import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HelloWorldDirective } from './hello-world.directive';
import { TodoFilterPipe } from './todo-filter.pipe';
import { TodoStatePipe } from './todo-state.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldDirective,
    TodoFilterPipe,
    TodoStatePipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

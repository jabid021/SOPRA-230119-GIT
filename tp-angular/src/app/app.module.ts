import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HelloWorldDirective } from './hello-world.directive';
import { TodoFilterPipe } from './todo-filter.pipe';
import { TodoStatePipe } from './todo-state.pipe';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscTextFieldComponent } from './asc-text-field/asc-text-field.component';
import { TodoFormComponent } from './todo-form/todo-form.component';
import { AscTooltipComponent } from './asc-tooltip/asc-tooltip.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldDirective,
    TodoFilterPipe,
    TodoStatePipe,
    HelloWorldComponent,
    AscBoldComponent,
    AscTextFieldComponent,
    TodoFormComponent,
    AscTooltipComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

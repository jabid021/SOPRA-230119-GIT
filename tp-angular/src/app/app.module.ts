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
import { RouterModule, Routes } from '@angular/router';
import { TodosComponent } from './todos/todos.component';
import { HomeComponent } from './home/home.component';
import { TodoDetailComponent } from './todo-detail/todo-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {path:"home", component: HomeComponent},
  {path:"todo", component: TodosComponent},
  {path:"todo/:id", component: TodoDetailComponent},
  {path :"", redirectTo: "home", pathMatch: 'full'},
  {path :"**", component: PageNotFoundComponent},
];

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
    AscTooltipComponent,
    TodosComponent,
    HomeComponent,
    TodoDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from '../todo';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent {
  todos: Array<Todo> = new Array<Todo>();

  inputSearch: string;
  
  todoForm: Todo = new Todo();

  constructor(private router: Router) {
    this.todos.push(new Todo(2, "Avis défaborable", false, 3));
    this.todos.push(new Todo(5, "Top produit", true, 3));
    this.todos.push(new Todo(6, "Produit conforme", true, 9));
  }

  ajouter() {
    this.todos.push(this.todoForm);
  }

  gotoDetail(id: number) {
    this.router.navigate(['/todo', id]);
  }
}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent {
  inputSearch: string;
  
  todoForm: Todo = new Todo();

  constructor(private router: Router, private todoService: TodoService) {
  }

  valider() {
    if(!this.todoForm.id) {
      this.todoService.create(this.todoForm);
    } else {
      this.todoService.update(this.todoForm);
    }

    this.todoForm = new Todo();
  }

  edit(id: number) {
    this.todoForm = {...this.todoService.findById(id)};
  }

  remove(id: number) {
    this.todoService.deleteById(id);
  }

  recherche() : Array<Todo>{
    if(this.inputSearch) {
      return this.todoService.findAllByTitre(this.inputSearch);
    }

    return this.todoService.findAll();
  }

  gotoDetail(id: number) {
    this.router.navigate(['/todo', id]);
  }
}

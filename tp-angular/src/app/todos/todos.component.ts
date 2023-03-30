import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { filter, map, Observable, of, Subscription, tap } from 'rxjs';
import { Todo } from '../todo';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent {
  inputSearch: string;
  
  todoForm: Todo = new Todo();
  obs: Observable<number> =  of(1,2,3,4,5);

  constructor(private router: Router, private todoService: TodoService) {
    this.obs = this.obs.pipe(
      filter(val => (val as number) > 2),
      map(val => (val as number) * 2)
    );
  }


  





  test() {
   
    let sub: Subscription=  this.obs.subscribe(val => {
      console.log(val);




    } );

    sub.unsubscribe();

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

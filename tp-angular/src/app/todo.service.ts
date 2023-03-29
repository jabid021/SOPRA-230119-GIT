import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private todos: Array<Todo> = new Array<Todo>();

  constructor() {
    this.todos.push(new Todo(2, "Avis défaborable", false, 3));
    this.todos.push(new Todo(5, "Top produit", true, 3));
    this.todos.push(new Todo(6, "Produit conforme", true, 9));
   }

   findAll(): Array<Todo> {
    return this.todos;
   }

   findById(id: number): Todo {
    return this.todos.find(t => t.id == id);
   }

   findAllByTitre(titre: string): Array<Todo> {
    return this.todos.filter(t => t.title.indexOf(titre) != -1);
   }

   create(todo: Todo): void {
      let max = 0;
      this.todos.forEach(t => {
        if(t.id > max) {
          max = t.id;
        }
      });

      todo.id = ++max;

      this.todos.push(todo);
   }

   update(todo: Todo): void {
      let position = this.todos.findIndex(t => t.id == todo.id);

      this.todos[position] = todo;
   }

   deleteById(id: number): void {
      let position = this.todos.findIndex(t => t.id == id);

      this.todos.splice(position, 1);
   }
}

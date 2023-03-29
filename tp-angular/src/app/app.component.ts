import { Component } from '@angular/core';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  prenom = 'Eric';
  nom="";

  couleur: string = "#000000";

  todos: Array<Todo> = new Array<Todo>();

  todo: Todo = new Todo(5, "A faire", true);

  inputSearch: string;
  
  constructor() {
    this.todos.push(new Todo(2, "Avis défaborable", false, 3));
    this.todos.push(new Todo(5, "Top produit", true, 3));
    this.todos.push(new Todo(6, "Produit conforme", true, 9));

    
  }

  todoForm: Todo = new Todo();
  
  ajouter() {
    this.todos.push(this.todoForm);
  }

  resetPrenom() {
    this.prenom = "";
  }

  changePrenom(event: any) {
    this.prenom = event.target.value;
  }

  majPrenom(data: string) {
    this.prenom = data.toUpperCase();
  }

  recherche() : Array<Todo>{
    if(this.inputSearch) {
      return this.todos.filter(t => t.title.toUpperCase().indexOf(this.inputSearch.toUpperCase()) != -1);
    } 

    return this.todos;
  }

  bidon(count: number) {
    alert(count);
  }

  todoMajTitre(titre: string) {
    this.todo.title = titre;
  }

  todoMajId(id: number) {
    this.todo.id = id;
  }
}

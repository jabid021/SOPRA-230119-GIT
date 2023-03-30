import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../todo';
import { TodoService } from '../todos/todo.service';

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrls: ['./todo-detail.component.css']
})


export class TodoDetailComponent {
  todo:Todo;

  constructor(private route: ActivatedRoute, private todoService: TodoService) {
    this.route.params.subscribe(params => {
      let monId = params['id'];

      this.todo = this.todoService.findById(monId);
    });

  }
}

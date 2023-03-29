import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrls: ['./todo-detail.component.css']
})


export class TodoDetailComponent {
  monId: any;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => this.monId = params['id']);

  }
}

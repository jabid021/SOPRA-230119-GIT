import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'asc-bold',
  templateUrl: './asc-bold.component.html',
  styleUrls: ['./asc-bold.component.css']
})
export class AscBoldComponent {
  compteur: number = 0;

  @HostListener("click")
  increment() {
    console.log(++this.compteur);
  }
}

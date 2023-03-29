import { Component, EventEmitter, HostListener, Input, Output } from '@angular/core';

@Component({
  selector: 'hello-world, hi, [hello], [hi]',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent {

  @Input("title")
  titre: string;
  
  @Input("value")
  valeur: string;

  @Output()
  clicked = new EventEmitter<number>();

  sonnette() {
    this.clicked.emit(55);
  }

  @HostListener("click")
  maMethode() {
    alert("dsjkjdfsjfdsjk");
  }

}

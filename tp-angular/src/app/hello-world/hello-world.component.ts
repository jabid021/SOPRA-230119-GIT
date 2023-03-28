import { Component, HostListener, Input } from '@angular/core';

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

  @HostListener("click")
  maMethode() {
    alert("dsjkjdfsjfdsjk");
  }

}

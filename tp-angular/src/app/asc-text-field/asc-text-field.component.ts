import { Component, Input } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  templateUrl: './asc-text-field.component.html',
  styleUrls: ['./asc-text-field.component.css']
})
export class AscTextFieldComponent {
  @Input("label")
  libelle: string;
  @Input("value")
  valeur: any;
  @Input()
  type: string = "text"
}

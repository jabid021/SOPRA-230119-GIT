import {Component, HostListener, Input, OnInit} from '@angular/core';

@Component({
  selector: 'asc-tooltip, [asc-tooltip]',
  templateUrl: './asc-tooltip.component.html',
  styleUrls: ['./asc-tooltip.component.css']
})
export class AscTooltipComponent implements OnInit {

  @Input("titre")
  titre: string;

  visible: boolean = false;

  constructor() {
  }

  ngOnInit() {
  }

  @HostListener("mouseenter")
  enter() {
    this.visible = true;
  }

  @HostListener("mouseleave")
  exit() {
    this.visible = false;
  }
}

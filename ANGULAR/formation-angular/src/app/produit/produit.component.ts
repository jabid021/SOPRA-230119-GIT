import { Component } from '@angular/core';
import { Produit } from '../model';
import { ProduitService } from './produit.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent {
  produitForm: Produit = null;

  constructor(private produitService: ProduitService) {

  }

  list(): Array<Produit> {
    return this.produitService.findAll();
  }

  add(): void {
    this.produitForm = new Produit();
  }

  edit(id: number): void {
    this.produitForm = {...this.produitService.findById(id)};
  }

  remove(id: number): void {
    this.produitService.remove(id);
  }

  save(): void {
    if(this.produitForm.id) {
      this.produitService.update(this.produitForm);
    } else {
      this.produitService.create(this.produitForm);
    }

    this.cancel();
  }

  cancel(): void {
    this.produitForm = null;
  }
}

import { Component } from '@angular/core';
import { FournisseurService } from '../fournisseur/fournisseur.service';
import { Fournisseur, Produit } from '../model';
import { ProduitService } from './produit.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent {
  produitForm: Produit = null;

  constructor(private produitService: ProduitService, private fournisseurService: FournisseurService) {

  }

  list(): Array<Produit> {
    return this.produitService.findAll();
  }

  listFournisseur(): Array<Fournisseur> {
    return this.fournisseurService.findAll();
  }

  add(): void {
    this.produitForm = new Produit();
    this.produitForm.fournisseur = new Fournisseur();  
  }

  edit(id: number): void {
    this.produitForm = {...this.produitService.findById(id)};

    if(!this.produitForm.fournisseur) {
      this.produitForm.fournisseur = new Fournisseur();
    } else {
      this.produitForm.fournisseur = {...this.produitForm.fournisseur};
    }
  }

  remove(id: number): void {
    this.produitService.remove(id);
  }

  save(): void {
    console.log(this.produitForm);
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

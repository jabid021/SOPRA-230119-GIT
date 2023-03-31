import { Component } from '@angular/core';
import { Observable, of, tap } from 'rxjs';
import { FournisseurService } from '../fournisseur/fournisseur.service';
import { Fournisseur, Produit, ProduitRequestResponse } from '../model';
import { ProduitHttpService } from './produit-http.service';
import { ProduitService } from './produit.service';
import { FournisseurHttpService } from '../fournisseur/fournisseur-http.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent {
  produitForm: ProduitRequestResponse = null;

  // produits$ : Observable<Array<Produit>>;

  constructor(private produitService: ProduitHttpService, private fournisseurService: FournisseurHttpService) {
  }

  list(): Array<Produit> {
    return this.produitService.findAll();
  }

  listFournisseur(): Array<Fournisseur> {
    return this.fournisseurService.findAll();
  }

  add(): void {
    this.produitForm = new ProduitRequestResponse()
    
  }

  edit(id: number): void {
    this.produitService.findById(id).subscribe(resp => {
      this.produitForm = resp;
    });
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

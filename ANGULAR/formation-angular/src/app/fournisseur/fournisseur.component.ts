import { Component } from '@angular/core';
import { Fournisseur } from '../model';
import { FournisseurHttpService } from './fournisseur-http.service';
import { FournisseurService } from './fournisseur.service';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.scss']
})
export class FournisseurComponent {

  fournisseurForm: Fournisseur = null;

  constructor(private fournisseurService: FournisseurHttpService) {

  }

  list(): Array<Fournisseur> {
    return this.fournisseurService.findAll();
  }

  add(): void {
    this.fournisseurForm = new Fournisseur();
  }

  edit(id: number): void {
    this.fournisseurService.findById(id).subscribe(resp => {
      this.fournisseurForm = resp;
    });
  }

  remove(id: number): void {
    this.fournisseurService.remove(id);
  }

  save(): void {
    if(this.fournisseurForm.id) {
      this.fournisseurService.update(this.fournisseurForm);
    } else {
      this.fournisseurService.create(this.fournisseurForm);
    }

    this.cancel();
  }

  cancel(): void {
    this.fournisseurForm = null;
  }
}

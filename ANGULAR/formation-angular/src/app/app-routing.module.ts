import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { ProduitComponent } from './produit/produit.component';
import { InscriptionComponent } from './inscription/inscription.component';

const routes: Routes = [
  {path: "", component: AccueilComponent, pathMatch: 'full'},
  {path: "fournisseur", component: FournisseurComponent},
  {path: "produit", component: ProduitComponent},
  {path: "inscription", component: InscriptionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

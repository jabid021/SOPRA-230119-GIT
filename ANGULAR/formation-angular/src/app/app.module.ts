import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { FournisseurService } from './fournisseur/fournisseur.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule }from '@angular/common/http';
import { ProduitComponent } from './produit/produit.component';
import { ProduitService } from './produit/produit.service';
import { FournisseurHttpService } from './fournisseur/fournisseur-http.service';
import { GlobalService } from './global.service';
import { ProduitHttpService } from './produit/produit-http.service';
import { InscriptionComponent } from './inscription/inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    AccueilComponent,
    FournisseurComponent,
    ProduitComponent,
    InscriptionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [GlobalService, FournisseurService, FournisseurHttpService, ProduitService, ProduitHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }

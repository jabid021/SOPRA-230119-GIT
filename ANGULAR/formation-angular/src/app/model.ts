export class Fournisseur {
    id: number;
    nom: string;

    constructor(id?: number, nom?: string) {
        this.id = id;
        this.nom = nom;
    }
}

export class Produit {
    id: number;
    libelle: string;
    prix: number;
    fournisseur: Fournisseur;

    constructor(id?: number, libelle?: string, prix?: number, fournisseur?: Fournisseur) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }
}
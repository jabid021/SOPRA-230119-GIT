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

    constructor(id?: number, libelle?: string, prix?: number) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
    }
}
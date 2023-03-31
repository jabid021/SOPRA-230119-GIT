import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {
  inscriptionForm: FormGroup;
  usernameCtrl: FormControl

  constructor(private formBuilder: FormBuilder) {

  }
  
  ngOnInit(): void {
    this.usernameCtrl = this.formBuilder.control('', Validators.required);

    this.inscriptionForm = this.formBuilder.group({
      username: this.usernameCtrl,
      email: this.formBuilder.control(''),
      password: this.formBuilder.control(''),
      passwordConfirm: this.formBuilder.control('')
    });
  }

  inscription() {
    console.log("Inscription");
    console.log(this.inscriptionForm.value)
  }

}

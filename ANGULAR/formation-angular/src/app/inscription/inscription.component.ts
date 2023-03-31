import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {
  inscriptionForm: FormGroup;
  usernameCtrl: FormControl;
  emailCtrl: FormControl;
  passwordCtrl: FormControl;
  passwordConfirmCtrl: FormControl;

  constructor(private formBuilder: FormBuilder) {

  }
  
  ngOnInit(): void {
    this.usernameCtrl = this.formBuilder.control('', Validators.required);
    this.emailCtrl = this.formBuilder.control('', [Validators.required, Validators.email]);
    this.passwordCtrl = this.formBuilder.control('', [Validators.required, Validators.minLength(8), Validators.pattern('^.*[A-Z]+.*$')]);
    this.passwordConfirmCtrl = this.formBuilder.control('', );

    this.inscriptionForm = this.formBuilder.group({
      username: this.usernameCtrl,
      email: this.emailCtrl,
      password: this.passwordCtrl,
      passwordConfirm: this.passwordConfirmCtrl
    });
  }

  inscription() {
    console.log("Inscription");
    console.log(this.inscriptionForm.value)
  }

}


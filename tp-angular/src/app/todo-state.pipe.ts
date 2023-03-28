import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todoState'
})
export class TodoStatePipe implements PipeTransform {

  transform(value: boolean, param?: string): string {
    if(value) {
      if(param=="string") {
        return "Terminé"
      } else {
        return "green";
      }
    } else {
      if(param=="string") {
        return "Non terminé"
      } else {
        return "red";
      }
    }

  }

}

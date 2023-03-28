import { Pipe, PipeTransform } from '@angular/core';
import { Todo } from './todo';

@Pipe({
  name: 'todoFilter'
})
export class TodoFilterPipe implements PipeTransform {

  transform(values: Array<Todo>, recherche: string): Array<Todo> {
    if(recherche) {
      return values.filter(t => t.title.toUpperCase().indexOf(recherche.toUpperCase()) != -1);
    }

    return values;
  }

}

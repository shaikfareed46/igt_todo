import {Todo} from './todo';
import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name: "sortByDate",
  pure: false
})
export class TodosSortPipe implements PipeTransform {
  transform(array: Todo[], args: any): Todo[] {
    console.log("calling pipe");
    
    if (array==null) return null;
    array.sort((a, b) => {
      if (a.todoDate < b.todoDate) {
        return -1;
      } else if (a.todoDate > b.todoDate) {
        return 1;
      } else {
        return 0;
      }
    });
    return array;
  }
}
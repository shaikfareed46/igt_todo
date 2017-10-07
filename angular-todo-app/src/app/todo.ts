export class Todo {
  id: number;
  title = '';
  complete = false;
  todoDate:Date;
  todoDateValue:string;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}

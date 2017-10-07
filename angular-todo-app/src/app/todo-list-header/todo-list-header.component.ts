import { DatePipe } from '@angular/common';
import { Component, Output, EventEmitter } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo-list-header',
  templateUrl: './todo-list-header.component.html',
  styleUrls: ['./todo-list-header.component.css']
})
export class TodoListHeaderComponent {

  newTodo: Todo = new Todo();
  private showDatepicker: boolean = false;

  minDate : Date = new Date()

  @Output()
  add: EventEmitter<Todo> = new EventEmitter();

  @Output() dateModelChange: EventEmitter<Date> = new EventEmitter();

  private transformDate(date: Date): string {
    var d = new DatePipe('pt-PT').transform(date, 'yyyy/MM/dd');
    return d;
  }

  constructor() {
  }

  addTodo() {
    this.add.emit(this.newTodo);
    this.newTodo = new Todo();
  }

  today(): void {
    this.newTodo.todoDate = new Date();
    this.apply();
    this.close();
  }
  clear(): void {
    this.newTodo.todoDate = void 0;
    this.close();
  }

  open() {
    this.showDatepicker = true;
  }
  close() {
    this.showDatepicker = false;
  }

  onSelectionDone(event) {
    this.newTodo.todoDate = event;
    this.apply();
    this.close();
  }
  onClickedOutside(event) {
    console.log("onClickedOutside", event);
    if (this.showDatepicker) this.close();
  }

  ngAfterViewInit() {
    this.newTodo.todoDate = new Date(this.newTodo.todoDateValue);
  }

  private apply(): void {
    this.newTodo.todoDateValue = this.transformDate(this.newTodo.todoDate);
    this.dateModelChange.emit(this.newTodo.todoDate);
  }

}

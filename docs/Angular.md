# Angular

TOC
  - [Angular (TypeScript)](#angular)
  - [Coding (Backend)](#coding_back)
  - [Coding (Frontend)](#coding_front)
  - [Others](#others)

# Angular (TypeScript) <a name="angular"></a>

Service, Component, Module
```
Service - classes that send data and functionality across components - (ng g/generate s/service shared/car/car)
  import { class } from '/.file/other';
  injectable
Component - reusable section of UI - (ng g/generate c/components car-list) - @angular/core
  selector - Name
  template / templateUrl - HTML
  styleUrls - CSS
Module
```

```
Classes
forEach, map, filter
Routing
Testing
Build Tools
Data Binding
Templating
HTTP Module
Observables, Promises - async (RxJS)
Arrow Functions
Form Module
Directives
Pipes
Events
Animation
TypeScript

MVC, SPA
```

Angular CLI - @angular/cli

```shell
ng new app  # generate new app
ng serve --open  # starts on port 4200 and open browser
```

Dependencies - Node.js & NPM

Files:
```shell
package.json  # like manifest in java, dependencies
DIR:
e2e - End to end testing
app
assets
environments

index.html
angular.json
styles.css

app.module.ts  # starting file
  @NgModule
    declariations  # list Components
    imports
    providers  # list Services
    bootstrap
    
app.component.ts  # root component
*.spec.ts  # file for testing
*.html
*.css
```



## Coding (Backend) <a name="coding_back"></a>

```typescript
String interpolation, Data Binding - {{name}}

Variables / model
name:string;
address:{
  street:string
};
testArr:any[];

interface Address{  # like class of model
...
}

Init methods:
constructor()  # Dependency Injection in constrution - of services
ngOnInit()

Arrays
  push  # insert on end
  unshift  # insert on begin
  splice  # delete


HTTP
getPost() {
  return this.http.get('url')  # return Observable
    .map(res => res.json());
}

getPost().subscribe((posts) => {
  console.log(posts)
});

import 'rxjs/add/operator/map';

ROUTER
const appRoutes: Routes = [
  {path: '', component:TestComponent}
];
RouterModule.forRoot(appRoutes)
```


## Coding (Frontend) <a name="coding_front"></a>

```html
# ngFor is a "structural directive". Structural directives shape or reshape the DOM's structure, typically by adding, removing, and manipulating the elements to which they are attached. Any directive with an * is a structural directive.
<div *ngFor="let product of products" />

# interpolation {{ }}
{{ product.name }}

# property binding [ ] 
<a [title]="product.name + ' details'">
  
<p *ngIf="product.description">

# Event binding ( )
<button (click)="share()">
  
  
<ul *ngIf=isEdit>
  <li *ngFor="let listElem of list; let i = index">{{i + 1}}: {{listElem}}</li>
</ul>

Events

<button (click)="onClick()">test</button>
<form (submit)="addTest(test.value)">
  <input type="text" #test>
  <input (change)="onToggle(test)" type="checkbox" />                   
</form>

<div [ngClass]="setClasses()">

Two way Data Binding
<input type="text" [(ngModel)]="test">

ROUTER
<a routerLink-"/">Test</a>
  
  
Component interaction

# @Input decorator indicates that the property value will be passed in from the component's parent (in this case, the product list component)

@Input() product;

# @Output decorator and an instance of event emitter. This makes it possible for the product alert component to emit an event when the value of the notify property changes.

@Output() notify = new EventEmitter();

<button (click)="notify.emit()">Notify Me</button>

onNotify() {
  window.alert('You will be notified when the product goes on sale');
}
  
<app-product-alerts
  [product]="product"
  (notify)="onNotify()">
</app-product-alerts> 




Lifecycle hooks
ngOnChanges()
ngOnInit()
ngDoCheck()
...



<div [ngSwitch]="hero?.emotion">
  <app-happy-hero    *ngSwitchCase="'happy'"    [hero]="hero"></app-happy-hero>
  <app-sad-hero      *ngSwitchCase="'sad'"      [hero]="hero"></app-sad-hero>
  <app-confused-hero *ngSwitchCase="'confused'" [hero]="hero"></app-confused-hero>
  <app-unknown-hero  *ngSwitchDefault           [hero]="hero"></app-unknown-hero>
</div>


asterisk (*) prefix
<div *ngIf="hero" class="name">{{hero.name}}</div>
===
<ng-template [ngIf]="hero">
  <div class="name">{{hero.name}}</div>
</ng-template>

<div *ngFor="let hero of heroes; let i=index; let odd=odd; trackBy: trackById" [class.odd]="odd">
  ({{i}}) {{hero.name}}
</div>
===
<ng-template ngFor let-hero [ngForOf]="heroes" let-i="index" let-odd="odd" [ngForTrackBy]="trackById">
  <div [class.odd]="odd">({{i}}) {{hero.name}}</div>
</ng-template>


Pipes
{{ birthday | date:"MM/dd/yy" }}
  
```

Modules:
```shell
BrowserModule
NgModule
FormsModule
HttpClientModule from '@angular/common/http'
RouterModule, Routes
EventEmitter, Input, Output
```

# Others <a name="others"></a>

PWA - Progressive Web Apps

Native - by Cordova, Ionic, NativeScript

Testing - Karma

## TypeScript

Super set of JavaScript

static typing

Created by Microsoft

Class based OOP - Object Oriented Programming

## Tools

Angular CLI

Angular Docs

https://compodoc.app/

State managers - ngrx, Redux

## Additional elems

URLs
```
angular.io
https://angular.io/resources
material.angular.io
https://angular-ui.github.io/bootstrap/
https://ng-bootstrap.github.io/#/home
```

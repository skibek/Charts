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

## TypeScript

Super set of JavaScript

static typing

Created by Microsoft

Class based OOP - Object Oriented Programming

## Tools

Angular CLI

State managers - ngrx, Redux

## Additional elems

URLs
```
angular.io
https://angular.io/resources
material.angular.io
```

# Angular

TOC
  - [Angular (TypeScript)](#angular)

# Angular (TypeScript) <a name="angular"></a>

```
Service - classes that send data and functionality across components - (ng g s shared/car/car)
  import { class } from '/.file/other';
  injectable
Component - section of UI - (ng g c/components car-list) - @angular/core
  selector
  template / templateUrl - HTML
  styleUrls - CSS
Routing
Testing
Build Tools
Data Binding
Templating
HTTP Module
Observables
Form Module
Directives
Pipes
Events
Animation
TypeScript
```

Module, 

Angular CLI - @angular/cli

```shell
ng new app  # generate new app
ng serve  # starts on port 4200
```

Dependencies - Node.js & NPM

Files:
```
package.json  # like manifest in java, dependencies
e2e - End to end testing

app.module.ts  # starting file
  @NgModule
    declariations  # list Components
    imports  # list Services
app.component.ts  # root component
*.spec.ts  # file for testing
*.html


```

Coding (Backend):
```typescript
String interpolation, Data Binding - {{name}}

Variables / model
name:string;
address:{
  street:string
};
testArr:any[];

interface Address{
...
}


Init methods:
constructor
ngOnInit


```


Coding (Frontend):
```html
<ul>
  <li *ngFor="let listElem of list; let i = index">{{i + 1}}: {{listElem}}</li>
</ul>

Events

<button (click)="onClick()">test</button>
```

## TypeScript

Super set of JavaScript

Created by Microsoft

Class based OOP - Object Oriented Programming

## Tools

Angular CLI

## Additional elems

material.angular.io

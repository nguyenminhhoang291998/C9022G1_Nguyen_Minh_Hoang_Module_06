import { Component, OnInit } from '@angular/core';
import {PersonService} from '../service/person.service';
import {Person} from '../model/person';

@Component({
  selector: 'app-personal-information',
  templateUrl: './personal-information.component.html',
  styleUrls: ['./personal-information.component.css']
})
export class PersonalInformationComponent implements OnInit {
  person: Person;

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.personService.getPersonInformation().subscribe(person => {
      this.person = person;
    });
  }

}

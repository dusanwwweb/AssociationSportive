import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

export class Sportif {
  constructor(
    public id: string,
    public idSportif: number,
    public nom: string,
    public prenom: string,
    public sexe: string,
    public age: string,
    public idSportifConseiller: string,
    public sports: Sport[]
  ){}
}

export class Sport {
  constructor(
    public jouer: string[],
    public arbitrer:string[],
    public entrainer:string[]
  ){}
}


@Component({
  selector: 'app-sportif',
  templateUrl: './sportif.component.html',
  styleUrls: ['./sportif.component.css']
})
export class SportifComponent implements OnInit {

  sportifs: Sportif[] | undefined;
  closeResult: string | undefined; 

  constructor(
    private httpClient: HttpClient,
    private modalService: NgbModal,
  ) { }

  ngOnInit(): void {
    this.getSportifs();
  }

  getSportifs(){
    this.httpClient.get<any>('http://localhost:8080/api/sportif').subscribe(
      response => {
        console.log(response);
        this.sportifs = response;
      }
    );
  }

  onSubmit(f: NgForm) {
    const url = 'http://localhost:8080/api/sportif';
    this.httpClient.post(url, f.value)
      .subscribe((result) => {
        this.ngOnInit(); 
      });
    this.modalService.dismissAll(); 
  }
  
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  openDetails(targetModal: any, sportif: Sportif) {
    this.modalService.open(targetModal, {
     centered: true,
     backdrop: 'static',
     size: 'lg'
   });
    document.getElementById('fname')!.setAttribute('value', sportif.nom);
    document.getElementById('lname')!.setAttribute('value', sportif.prenom);
    document.getElementById('sx')!.setAttribute('value', sportif.sexe);
    document.getElementById('ag')!.setAttribute('value', sportif.age);
    document.getElementById('cons')!.setAttribute('value', sportif.idSportifConseiller);
 }

 openDelete(targetModal: any, sportif: Sportif) {
  this.modalService.open(targetModal, {
    backdrop: 'static',
    size: 'md'
  });
}
}

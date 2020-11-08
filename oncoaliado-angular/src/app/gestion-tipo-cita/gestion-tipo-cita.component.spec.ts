import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionTipoCitaComponent } from './gestion-tipo-cita.component';

describe('GestionTipoCitaComponent', () => {
  let component: GestionTipoCitaComponent;
  let fixture: ComponentFixture<GestionTipoCitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionTipoCitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionTipoCitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

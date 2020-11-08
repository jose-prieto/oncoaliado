import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearTipoCitaComponent } from './crear-tipo-cita.component';

describe('CrearTipoCitaComponent', () => {
  let component: CrearTipoCitaComponent;
  let fixture: ComponentFixture<CrearTipoCitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearTipoCitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearTipoCitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

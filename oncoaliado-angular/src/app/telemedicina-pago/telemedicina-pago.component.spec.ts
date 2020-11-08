import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelemedicinaPagoComponent } from './telemedicina-pago.component';

describe('TelemedicinaPagoComponent', () => {
  let component: TelemedicinaPagoComponent;
  let fixture: ComponentFixture<TelemedicinaPagoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelemedicinaPagoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TelemedicinaPagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

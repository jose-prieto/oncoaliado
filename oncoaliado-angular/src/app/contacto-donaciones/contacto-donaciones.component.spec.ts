import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactoDonacionesComponent } from './contacto-donaciones.component';

describe('ContactoDonacionesComponent', () => {
  let component: ContactoDonacionesComponent;
  let fixture: ComponentFixture<ContactoDonacionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactoDonacionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactoDonacionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

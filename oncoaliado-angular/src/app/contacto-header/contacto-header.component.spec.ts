import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactoHeaderComponent } from './contacto-header.component';

describe('ContactoHeaderComponent', () => {
  let component: ContactoHeaderComponent;
  let fixture: ComponentFixture<ContactoHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactoHeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactoHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

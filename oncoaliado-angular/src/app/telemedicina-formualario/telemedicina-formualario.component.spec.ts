import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelemedicinaFormualarioComponent } from './telemedicina-formualario.component';

describe('TelemedicinaFormualarioComponent', () => {
  let component: TelemedicinaFormualarioComponent;
  let fixture: ComponentFixture<TelemedicinaFormualarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelemedicinaFormualarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TelemedicinaFormualarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

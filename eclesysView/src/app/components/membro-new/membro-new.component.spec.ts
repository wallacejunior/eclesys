import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MembroNewComponent } from './membro-new.component';

describe('MembroNewComponent', () => {
  let component: MembroNewComponent;
  let fixture: ComponentFixture<MembroNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MembroNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MembroNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

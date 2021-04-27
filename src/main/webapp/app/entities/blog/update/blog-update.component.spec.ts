jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { BlogService } from '../service/blog.service';
import { IBlog, Blog } from '../blog.model';

import { BlogUpdateComponent } from './blog-update.component';

describe('Component Tests', () => {
  describe('Blog Management Update Component', () => {
    let comp: BlogUpdateComponent;
    let fixture: ComponentFixture<BlogUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let blogService: BlogService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [BlogUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(BlogUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(BlogUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      blogService = TestBed.inject(BlogService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should update editForm', () => {
        const blog: IBlog = { id: 456 };

        activatedRoute.data = of({ blog });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(blog));
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject();
        const blog = { id: 123 };
        spyOn(blogService, 'update').and.returnValue(saveSubject);
        spyOn(comp, 'previousState');
        activatedRoute.data = of({ blog });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: blog }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(blogService.update).toHaveBeenCalledWith(blog);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject();
        const blog = new Blog();
        spyOn(blogService, 'create').and.returnValue(saveSubject);
        spyOn(comp, 'previousState');
        activatedRoute.data = of({ blog });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: blog }));
        saveSubject.complete();

        // THEN
        expect(blogService.create).toHaveBeenCalledWith(blog);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject();
        const blog = { id: 123 };
        spyOn(blogService, 'update').and.returnValue(saveSubject);
        spyOn(comp, 'previousState');
        activatedRoute.data = of({ blog });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(blogService.update).toHaveBeenCalledWith(blog);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });
  });
});

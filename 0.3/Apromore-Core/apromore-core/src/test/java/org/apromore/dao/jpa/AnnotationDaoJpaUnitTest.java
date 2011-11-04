package org.apromore.dao.jpa;

import org.apromore.dao.model.Annotation;
import org.apromore.dao.model.Canonical;
import org.apromore.dao.model.Native;
import org.apromore.exception.AnnotationNotFoundException;
import org.apromore.exception.CanonicalFormatNotFoundException;
import org.apromore.test.heuristic.JavaBeanHeuristic;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

/**
 * Test the Annotation DAO JPA class.
 * @author <a href="mailto:cam.james@gmail.com">Cameron James</a>
 */
@RunWith(PowerMockRunner.class)
public class AnnotationDaoJpaUnitTest {

    private AnnotationDaoJpa dao;
    private EntityManager manager;


    @Before
    public final void setUp() throws Exception {
        dao = new AnnotationDaoJpa();
        EntityManagerFactory factory = createMock(EntityManagerFactory.class);
        manager = createMock(EntityManager.class);
        dao.setEntityManagerFactory(factory);
        expect(factory.createEntityManager()).andReturn(manager).anyTimes();
        replay(factory);
    }

    @Test
    public final void testIsAPOJO() {
        JavaBeanHeuristic.assertLooksLikeJavaBean(AnnotationDaoJpa.class);
    }


    @Test
    public final void testGetAllAnnotations() {
        int uri = 123;
        List<Annotation> anns = new ArrayList<Annotation>();
        anns.add(createAnnotation());

        Query query = createMock(Query.class);
        expect(manager.createNamedQuery(Annotation.FIND_BY_URI)).andReturn(query);
        expect(query.setParameter("uri", uri)).andReturn(query);
        expect(query.getResultList()).andReturn(anns);

        replay(manager, query);

        List<Annotation> annotations = dao.findByUri(uri);

        verify(manager, query);

        assertThat(anns.size(), equalTo(annotations.size()));
    }

    @Test
    public final void testGetAllAnnotationsNonFound() {
        int uri = 123;
        List<Annotation> anns = new ArrayList<Annotation>();

        Query query = createMock(Query.class);
        expect(manager.createNamedQuery(Annotation.FIND_BY_URI)).andReturn(query);
        expect(query.setParameter("uri", uri)).andReturn(query);
        expect(query.getResultList()).andReturn(anns);

        replay(manager, query);

        List<Annotation> annotations = dao.findByUri(uri);

        verify(manager, query);

        assertThat(annotations, equalTo(anns));
    }

    @Test
    public final void testGetAnnotation() throws Exception {
        long processId = 123;
        String versionName = "123";
        String name = "annName";

        String annotationXML = "<XML/>";

        Query query = createMock(Query.class);
        expect(manager.createNamedQuery(Annotation.GET_ANNOTATION)).andReturn(query);
        expect(query.setParameter("processId", processId)).andReturn(query);
        expect(query.setParameter("versionName", versionName)).andReturn(query);
        expect(query.setParameter("name", name)).andReturn(query);
        expect(query.getSingleResult()).andReturn(annotationXML);

        replay(manager, query);

        String annotationStr = dao.getAnnotation(processId, versionName, name);

        verify(manager, query);

        MatcherAssert.assertThat(annotationXML, Matchers.equalTo(annotationStr));
    }

    @Test(expected = AnnotationNotFoundException.class)
    public final void testGetAnnotationNotFound() throws Exception {
        long processId = 123;
        String versionName = "123";
        String name = "annName";

        String annotationXML = null;

        Query query = createMock(Query.class);
        expect(manager.createNamedQuery(Annotation.GET_ANNOTATION)).andReturn(query);
        expect(query.setParameter("processId", processId)).andReturn(query);
        expect(query.setParameter("versionName", versionName)).andReturn(query);
        expect(query.setParameter("name", name)).andReturn(query);
        expect(query.getSingleResult()).andReturn(annotationXML);

        replay(manager, query);

        dao.getAnnotation(processId, versionName, name);

        verify(manager, query);
    }


    @Test
    public final void testSaveAnnotation() {
        Annotation ann = createAnnotation();
        manager.persist(ann);
        replay(manager);
        dao.save(ann);
        verify(manager);
    }

    @Test
    public final void testUpdateAnnotation() {
        Annotation ann = createAnnotation();
        expect(manager.merge(ann)).andReturn(ann);
        replay(manager);
        dao.update(ann);
        verify(manager);
    }


    @Test
    public final void testDeleteAnnotation() {
        Annotation ann = createAnnotation();
        manager.remove(ann);
        replay(manager);
        dao.delete(ann);
        verify(manager);
    }


    private Annotation createAnnotation() {
        Annotation a = new Annotation();

        a.setCanonical("123456");
        a.setContent("12345");
        a.setName("newCanonical");
        a.setNatve(new Native());
        a.setUri(12425535);

        return a;
    }
}

package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PublisherService {
    private final PublisherDao publisherDao;

    public void savePublisher(Publisher publisher) {
        publisherDao.savePublisher(publisher);
    }

    public Publisher findById(long id) {
        return publisherDao.findById(id);
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void delete(Publisher publisher) {
        publisherDao.delete(publisher);
    }

    public List<Publisher>getAll(){
       return publisherDao.getAll();
    }
}

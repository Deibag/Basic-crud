package test.back.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import test.back.domain.Item;
import test.back.model.ItemDTO;
import test.back.repos.ItemRepository;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDTO> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(item -> mapToDTO(item, new ItemDTO()))
                .collect(Collectors.toList());
    }

    public ItemDTO get(final Integer id) {
        return itemRepository.findById(id)
                .map(item -> mapToDTO(item, new ItemDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Integer create(final ItemDTO itemDTO) {
        final Item item = new Item();
        mapToEntity(itemDTO, item);
        return itemRepository.save(item).getId();
    }

    public void update(final Integer id, final ItemDTO itemDTO) {
        final Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(itemDTO, item);
        itemRepository.save(item);
    }

    public void delete(final Integer id) {
        itemRepository.deleteById(id);
    }

    private ItemDTO mapToDTO(final Item item, final ItemDTO itemDTO) {
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        return itemDTO;
    }

    private Item mapToEntity(final ItemDTO itemDTO, final Item item) {
        item.setName(itemDTO.getName());
        return item;
    }

}

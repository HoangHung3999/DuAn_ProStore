package fpoly.sonhaph40315_20_6.duan_prostore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.dao.LienHeDao;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.LienHeAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.model.LienHe;

public class LienHeFragment extends Fragment {

    private RecyclerView recyclerContact;
    private LienHeAdapter adapter;
    private LienHeDao contactDao;

    public LienHeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lien_he, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerContact = view.findViewById(R.id.recyclerContact);
        contactDao = new LienHeDao(requireContext());

        List<LienHe> contactList = contactDao.getAllContacts();

        adapter = new LienHeAdapter(requireContext(), contactList);
        recyclerContact.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerContact.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.setData(contactDao.getAllContacts());
        }
    }
}

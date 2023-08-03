import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kz.singularity.domain.models.User
import kz.singularity.learningcompose.ui.main.MainViewModel
import kz.singularity.learningcompose.ui.theme.CustomTheme
import kz.singularity.learningcompose.ui.users.UserPageViewModel
import kz.singularity.learningcompose.ui.views.AddressCard
import kz.singularity.learningcompose.ui.views.CompanyCard
import kz.singularity.learningcompose.ui.views.UserInfo
import org.koin.androidx.compose.get

@Composable
fun UserProfilePage(userId: Long, viewModel: UserPageViewModel = get()) {
    val user = viewModel.getUserById(userId = userId)
    if (user != null) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
        ) {
            item {
                Text(
                    text = user.username,
                    style = MaterialTheme.typography.h1,
                    color = CustomTheme.colors.text01,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(24.dp))
                UserInfo(
                    userEmail = user.email,
                    fullName = user.name,
                    phoneNumber = user.phone,
                    website = user.website
                )
                Spacer(modifier = Modifier.size(20.dp))

                Text(
                    text = "Company",
                    style = MaterialTheme.typography.h2,
                    color = CustomTheme.colors.text01,
                )
                Spacer(modifier = Modifier.size(16.dp))
                val company = user.company
                CompanyCard(
                    companyName = company.name,
                    fullName = company.catchPhrase,
                    service = company.bs
                )

                Spacer(modifier = Modifier.size(24.dp))
                Text(
                    text = "Address",
                    style = MaterialTheme.typography.h2,
                    color = CustomTheme.colors.text01,
                )
                Spacer(modifier = Modifier.size(16.dp))
                val address = user.address
                AddressCard(
                    street = address.street,
                    suite = address.suite,
                    City = address.city,
                    Zipcode = address.zipcode
                )
            }
        }
    }
}

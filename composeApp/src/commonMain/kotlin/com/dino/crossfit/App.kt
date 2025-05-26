package com.dino.crossfit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastRoundToInt
import com.dino.crossfit.ui.theme.DinoTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    DinoTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text("DinoCrossFit")
                    }
                )
            },
        ) { contentPadding ->
            var selectedOneRepMax: Data.OneRepMax by remember { mutableStateOf(Data.OneRepMax.entries.first()) }
            var selectedWeek: Data.Week by remember { mutableStateOf(Data.Week.entries.first()) }

            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(contentPadding)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // 1rm 선택
                Text(
                    text = "Training",
                    style = MaterialTheme.typography.titleLarge
                )
                Column(
                    modifier = Modifier.selectableGroup()
                ) {
                    Data.OneRepMax.entries.forEach { oneRepMax ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = selectedOneRepMax == oneRepMax,
                                    onClick = { selectedOneRepMax = oneRepMax },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 16.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedOneRepMax == oneRepMax,
                                onClick = null
                            )
                            Text(
                                text = "${oneRepMax.name}: ${oneRepMax.value}",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

                // week 선택
                Text(
                    text = "Week",
                    style = MaterialTheme.typography.titleLarge
                )
                Column(
                    modifier = Modifier.selectableGroup()
                ) {
                    Data.Week.entries.forEachIndexed { index, week ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = selectedWeek == week,
                                    onClick = { selectedWeek = week },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 16.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedWeek == week,
                                onClick = null
                            )
                            Text(
                                text = "${index + 1}주차",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }

                // 결과 화면
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

                Text(
                    text = "Result",
                    style = MaterialTheme.typography.titleLarge
                )

                selectedWeek.weekSet.forEachIndexed { index, week ->
                    Text(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 16.dp),
                        text = "- Set${index + 1} ${(week.tm * 0.9 * selectedOneRepMax.value).fastRoundToInt()} x ${week.reps} reps",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

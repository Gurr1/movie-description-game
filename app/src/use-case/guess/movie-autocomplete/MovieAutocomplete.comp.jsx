import CircularProgress from "@material-ui/core/CircularProgress";
import Autocomplete from "@material-ui/core/Autocomplete";
import TextField from "@material-ui/core/TextField";
import { useEffect, useState } from "react";

const MovieAutocomplete = ({ movie, onMovieChanged }) => {
  const [open, setOpen] = useState(false);
  const [search, setSearch] = useState("");
  const [options, setOptions] = useState([]);
  const loading = open && options.length === 0;

  useEffect(() => {
    console.log('searching... "' + search + '"');
    setOptions([]);
    setTimeout(() => {
      setOptions([{ name: "Lord" }]);
    }, 2000);
  }, [loading, search]);

  useEffect(() => {
    if (!open) {
      setOptions([]);
    }
  }, [open]);

  return (
    <Autocomplete
      open={open}
      onOpen={() => {
        setOpen(true);
      }}
      onClose={() => {
        setOpen(false);
      }}
      getOptionSelected={(option, value) => option.name === value.name}
      getOptionLabel={(option) => option.name}
      options={options}
      loading={loading}
      value={movie}
      onChange={(e, newValue) => {
        onMovieChanged(newValue);
      }}
      renderInput={(params) => (
        <TextField
          {...params}
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          label="Select movie"
          InputProps={{
            ...params.InputProps,
            endAdornment: (
              <>
                {loading ? (
                  <CircularProgress color="inherit" size={20} />
                ) : null}
                {params.InputProps.endAdornment}
              </>
            ),
          }}
        />
      )}
    />
  );
};

export default MovieAutocomplete;
